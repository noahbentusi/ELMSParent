package dataSuper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.DocState;
import util.MyDate;
import util.ResultMessage;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * 所有数据实现层的父类
 * 
 * @author czq
 * @version 2015年10月31日 上午9:18:30
 */
public class DataSuperClass extends UnicastRemoteObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 与数据库的连接
	 */
	protected Connection conn;
	/**
	 * 
	 */
	protected PreparedStatement preState;
	/**
	 * 数据库语句
	 */
	protected String sql;
	/**
	 * 数据库操作影响结果集
	 */
	protected ResultSet result;
	/**
	 * 查找返回的消息
	 */
	protected ArrayList<String> findMes;
	/**
	 * 在数据库操作中影响到的行数（信息条数）
	 */
	protected int affectRows;
	/**
	 * 
	 */
	protected static DataServiceHelper helper = new DataServiceHelper();

	private static final Map<String, ArrayList<String>> SQLmap = new HashMap<String, ArrayList<String>>(50);

	static {
		SQLmap.put("account", helper.bulidSQL("account", 6, "id", "name", "type", "password","phone", "email"));
		SQLmap.put("person", helper.bulidSQL("person" , 5 , "id" , "instid" , "name" , "type" ,"phone"));
		SQLmap.put("inst", helper.bulidSQL("inst", 3, "id" , "location" , "type"));
		SQLmap.put("car",helper.bulidSQL("car", 4, "id" , "instid", "plateNum" , "useYear") );
		SQLmap.put("driver", helper.bulidSQL("driver", 8, "id", "name" , "birthday" ,  "instid" ,"idCard" , "phoneNum" , "isman" , "licenseYear" ));
		SQLmap.put("myorder", helper.bulidSQL("myorder" , 36 , "id" , "type" , "date" , "state" , "senderName" , "senderPhone" ,"senderCompany" , "senderAddress" , "receiverName" , "receiverPhone" , "receiverCompany" , "receiverAddress" , "goodNum" , "goodName" , "goodWeight" , "goodLong" , "goodWidth" , "goodHeight" , "goodPack" , "orderForm" , "orderstartdate", "orderEestiTime" , "orderCost" , "loadDoc" , "arriveZZOneDoc" ,"inStoreOneDoc" , "outStoreOneDoc", "transferDoc" ,"arriveZZTwoDoc", "instoreTwoDoc" , "outStoreTwoDoc","arriveYYDoc" , "sendGoodDoc" ,"allDocs","realReceiver" ,"orderReceiveDate"));
		SQLmap.put("salary", helper.bulidSQL("salary", 4, "type" , "basicSalary" , "moreMoney" , "way"));
		SQLmap.put("LoadDoc", helper.bulidSQL("LoadDoc", 11 , "id", "type" , "date" , "state", "YYID" , "LoadDocID" ,"arriveCity" ,"carID" ,"Supervisor" ,"Escort" , "orderBarCodes"));
		SQLmap.put("SendGoodDoc", helper.bulidSQL("SendGoodDoc", 6,  "id", "type" , "date" , "state", "sendMan" , "orderBarCode" ));
		SQLmap.put("TransferDoc", helper.bulidSQL("TransferDoc", 9, "id", "type" , "date" , "state", "TransferWayID" ,"sendCity" ,"containerNum" ,"loadManName" ,"orderBarCode"));
		SQLmap.put("ArriveZZDoc", helper.bulidSQL("ArriveZZDoc", 8, "id", "type" , "date" , "state", "ZZID" , "sendCity" , "goodState", "orderBarCodes"));
		SQLmap.put("ArriveYYDoc", helper.bulidSQL("ArriveYYDoc", 8, "id", "type" , "date", "state" , "ZZID" , "sendInst" , "goodState", "orderBarCodes"));
		SQLmap.put("InStoreDoc", helper.bulidSQL("InStoreDoc", 7, "id", "type" , "date", "state" , "orderPOs" , "loc" ,"location" ));
		SQLmap.put("OutStoreDoc", helper.bulidSQL("OutStoreDoc", 8, "id", "type" , "date", "state" , "orderPOs" , "loc" ,"transferDoc" ,"shipWay" ));
		SQLmap.put("BankAccount", helper.bulidSQL("BankAccount", 3, "id" , "password" , "money"));
		SQLmap.put("PayDoc", helper.bulidSQL("PayDoc", 8, "id", "type" , "date", "state" , "money", "yyid"  ,"courier" ,"orders"));
		
		SQLmap.put("StateForm", helper.bulidSQL("StateForm", 4, "startDate" , "endDate" , "deposits" ,"pays"));
		SQLmap.put("CostIncomeForm", helper.bulidSQL("CostIncomeForm", 4, "income" , "expense" , "startDate" , "endDate"));
		SQLmap.put("bill", helper.bulidSQL("bill", 5, "finaceMan" , "date" , "instituations" , "persons" ,"cars" ));
		SQLmap.put("deposit", helper.bulidSQL("deposit", 3, "id" ,"date" , "money"));
		SQLmap.put("pay", helper.bulidSQL("pay", 9 , "id" , "time" , "account", "money" , "person" , "rent" , "freight" , "salary" , "state"));
		SQLmap.put("rent", helper.bulidSQL("rent", 5, "id","startDate" , "endDate" , "money" , "type" ,"costType"));
		SQLmap.put("freight", helper.bulidSQL("freight", 5, "id","startDate" , "endDate" , "money"  ,"costType"));
		SQLmap.put("salarycost", helper.bulidSQL("salarycost", 6,"id", "startDate" , "endDate" , "money"  ,"costType" , "worker"));
		SQLmap.put("StoreCheck", helper.bulidSQL("StoreCheck", 6, "date" , "location" , "storeLoc" , "number" , "total", "inStoreDocs" ,"outStoreDocs"));
		SQLmap.put("alarm", helper.bulidSQL("alarm", 2, "city" , "value"));
	}

	public DataSuperClass() throws RemoteException {
		this.conn = DataBaseInit.getConnection();
		System.out.println("succeed to bulid dataservice");
	}
	
//	/**
//	 * 初始化数据
//	 */
//	protected void intial() {
//		
//	}
	

	/**
	 * 向数据库中增加一条数据
	 * @param tableName 表的名字
	 * @param paras 可变参数列表
	 * @return
	 */
	protected ResultMessage addToSQL(String tableName , String... paras) {
		try {
			int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
			preState = conn.prepareStatement(SQLmap.get(tableName).get(1));
			for (int i = 0; i < paralen; i++) {
				preState.setString(i + 1, paras[i]);
			}
			affectRows = preState.executeUpdate();
		} catch(MySQLIntegrityConstraintViolationException e){
			return ResultMessage.hasExist;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
		if(affectRows == 0){
			return ResultMessage.FAIL;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 从数据库中删除一个数据
	 * @param tableName 表的名字
	 * @param ID 要删除数据的ID
	 * @return
	 */
	protected ResultMessage delFromSQL(String tableName , String ID) {
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(2) +"\"" + ID + "\"");
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
		if(affectRows != 1){
			return ResultMessage.NOT_EXIST;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	
	/**
	 * 在数据库中查找一条消息
	 * @param tableName 表的名字
	 * @param ID 要查找数据的ID
	 * @return 找不到事返回null，否则返回PO类所有信息
	 */
	protected ArrayList<String> findFromSQL(String tableName, String ID) {
		
		
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(3) + "\""+ ID + "\"");
			result = preState.executeQuery();
			if(result.next()) {
				// 如果查找到对应的ID
				int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
				ArrayList<String> temp = new ArrayList<String>(paralen);
				for (int i = 0; i < paralen; i++) {
					temp.add(result.getString(i + 1));
				}
				return temp;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	/**
	 * 用于没有ID的SQL处理
	 * @param tableName
	 * @return
	 */
	protected ArrayList<String> findFromSQL(String tableName){
		ArrayList<String> temp = new ArrayList<String>();
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(3));
			result = preState.executeQuery();
			while(result.next()) {
				int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
				temp = new ArrayList<String>(paralen);
				for (int i = 0; i < paralen; i++) {
					temp.add(result.getString(i + 1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(temp.size() == 0 ) {
			return null;
		}else{
			return temp;
		}
	}
	
	/**
	 * 用于没有ID的SQL处理
	 * @param tableName
	 * @return
	 */
//	protected ArrayList< ArrayList<String> > findFromSQL(String sql , int paralen){
//		ArrayList< ArrayList<String> > result = new ArrayList<>();
//		ArrayList<String> temp;
//		try {
//			preState = conn.prepareStatement(sql);
//			result = preState.executeQuery();
//			while(result.next()) {
//				temp = new ArrayList<String>(paralen);
//				for (int i = 0; i < paralen; i++) {
//					temp.add(result.getString(i + 1));
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if(temp.size() == 0 ) {
//			return null;
//		}else{
//			return temp;
//		}
//	}
	
	/**
	 * 修改一条数据
	 * @param tableName 表的名字
	 * @param newParas  PO参数列表
	 * @return 
	 */
	protected ResultMessage modifyFromSQL(String tableName , String... newParas) {
		
		try {
			int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
			preState = conn.prepareStatement(SQLmap.get(tableName).get(4) +"\"" + newParas[0]  +"\"");
			for (int i = 0; i < paralen - 1; i++) {
				preState.setString(i + 1, newParas[i + 1]);
			}
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
		if(affectRows == 0){
			return ResultMessage.NOT_EXIST;
		}else if(affectRows > 1){
			return ResultMessage.FAIL;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage changeOneDocState (String docID,
			String tableName, DocState state) {
		
		try {
			sql = "UPDATE `" + tableName + "` SET state =  ? WHERE id = "+"\"" + docID+"\"" ;
			preState = conn.prepareStatement(sql);
			preState.setString(1, state.name());
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		if(affectRows == 0){
			return ResultMessage.NOT_EXIST;
		}else{
			return ResultMessage.SUCCESS;
		}
		
		
	}
	
	
	
	/**
	 * 清除表内所有信息
	 * @param tableName
	 * @return
	 */
	protected ResultMessage initialFromSQL(String tableName) {
		
		try {
			sql = SQLmap.get(tableName).get(5);
			preState = conn.prepareStatement(sql);

			preState.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	/**
	 * 执行语句并返回执行结果
	 * 
	 * @param tempPreState
	 * @return
	 */
	protected ResultMessage getDoResult(PreparedStatement tempPreState) {
		try {
			if (tempPreState.execute()) {
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	protected int  getDayDocCount(String tableName, MyDate date) {
		try {
			sql = "SELECT id from " + tableName + " ORDER BY `id` DESC";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			String nowDate = MyDate.getDatePart(date);
			while (result.next()) {
				
				String id = result.getString(1);
				if(id.length() == 10){
				}else if(id.length() == 16){
					if(id.substring(3, 9).equals(nowDate)){
						
						try {
							return Integer.parseInt(id.substring(id.length() - 7)) + 1;
						} catch (Exception e) {
							return -1;
						}
					}else{
						return 1;
					}
					
					
					
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1 ;
	}
	
	

	/**
	 * 仅供测试
	 */
	public void showSQLMap() {
		for (Entry<String, ArrayList<String>> temp : SQLmap.entrySet()) {
			System.out.println(temp.getKey());
			for (int i = 0; i < 6; i++) {
				System.out.println(temp.getValue().get(i));
				
			}
			System.out.println("------------------------------------------------");

		}
	}

}
