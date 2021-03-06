package bl.personnelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import bl.BusinessController;
import blservice.personnelblservice.Personnelblservice;
import ds.personneldataservice.PersonnelDataService;
import exception.ExceptionHandler;
 /** 
 * 人員機構管理控制類
 * @author czq 
 * @version 2015年11月15日 上午9:24:36 
 */
public class PersonnelController extends BusinessController implements Personnelblservice{
	private Personnel per;
	private PersonnelDataService personnelDataService;
	public PersonnelController() {
		myType = DataServiceType.PersonnelDataService;
		personnelDataService = (PersonnelDataService) RMIManage.getDataService(DataServiceType.PersonnelDataService);
		per = new Personnel(personnelDataService);
	}
	@Override
	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		try {
			return per.getPeopleByInst(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getPeopleByInst(ID);
			}
		}return null;
	}

	@Override
	public PersonVO getPeopleByID(String ID) {
		try {
			return per.getPeopleByID(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
			return getPeopleByID(ID);
			}
		}return null;
	}

	@Override
	public ArrayList<PersonVO> getPeopleByName(String name) {
		try {
			return per.getPeopleByName(name);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getPeopleByName(name);
			}
		}return null;
	}

	@Override
	public ResultMessage addPeople(PersonVO vo) {
		try {
			return per.addPeople(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return addPeople(vo);
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delPeople(String ID) {
		try {
			return per.delPeople(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return delPeople(ID);
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage addInst(InstVO vo) {
		try {
			return per.addInst(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return addInst(vo);
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delInst(String ID) {
		try {
			return per.delInst(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return delInst(ID);
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<InstVO> getInst() {
		try {
			return per.getInst();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getInst();
			}
		}return null;
	}
	@Override
	public ArrayList<PersonVO> getPersons() {
		try {
			return per.getPersons();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getPersons();
			}
		}return null;
	}
	@Override
	public ResultMessage modifyInst(InstVO vo) {
		
		try {
			return per.modifyInst(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return modifyInst(vo);
			}
		}return ResultMessage.FAIL;
	}
	@Override
	public ResultMessage modifyPerson(PersonVO vo) {
		
		try {
			return per.modifyPerson(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return modifyPerson(vo);
			}
		}return ResultMessage.FAIL;
	}
	@Override
	public void reinitDataService(Remote dataService) {
		personnelDataService = (PersonnelDataService) dataService;
		per = new Personnel(personnelDataService);
		
	}

}
