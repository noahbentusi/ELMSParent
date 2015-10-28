package vo;
/**
 * 薪水信息
 * @author ymc
 *
 */
public class SalaryVO extends CostVO {
	/**
	 * 员工类型(driver,courier,workman)
	 */
	String worker;

	public SalaryVO(int money, String type, String worker) {
		super(money, type);
		this.worker = worker;
	}
	

}
