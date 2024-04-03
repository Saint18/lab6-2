
/*
This class has to be redesigned to use the generic tree node system instead of the former system. 
I've included a backup of this file in case it is useful to you. 
You'll need to populate the body based on the module and add the requested additional functionality.
*/
import java.util.ArrayList;
import java.util.List;

public class OrganizationImpl implements Organization {
	private Supervisor boss; //the top level supervisor/ceo
	
	
	//constructor to initialize the organization with the ceo
	public OrganizationImpl(String name, double pay, Gender gender) {
		this.boss = new Supervisor(name, pay, gender); 
	}
	
	
	//method to add employees
	@Override
	public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
		Employee newEmployee = new NonManagerEmployee(name, pay, gender);
		addEmployeeUnderSupervisor(newEmployee, supervisorName);
	}
	
	
	//Method to add contract employee under supervisor. 
	@Override
	public void addContractEmployee(String name, double pay, Gender gender, int endDate, int endMonth, int endYear, String supervisorName) {
		Employee newContractEmployee = new ContractEmployee(name, pay, gender, endDate, endMonth, endYear);
		addEmployeeUnderSupervisor(newContractEmployee, supervisorName);
	}
	
	
	//method to add employee under supervisor
	private void addEmployeeUnderSupervisor(Employee employee, String supervisorName) {
		if (boss.getName().equals(supervisorName)) {
			boss.addSupervisee(supervisorName, employee);
		}else {
			addSuperviseeRecursive(boss, supervisorName, employee);
		}
	}
	
	
	//recursive method for adding supervisee
	private boolean addSuperviseeRecursive(Supervisor supervisor, String supervisorName, Employee supervisee) {
		if(supervisor.getName().equals(supervisorName)) {
			supervisor.addSupervisee(supervisorName, supervisee);
			return true;
		}else {
			for(Employee e : supervisor.getSuperviseeList()) {
				if(e instanceof Supervisor) {
					boolean added = addSuperviseeRecursive((Supervisor)e, supervisorName, supervisee);
					if (added) return true;
					
				}
			}
		}
		return false;
	}
	
	
	//method to get size 
	@Override
	public int getSize() {
		return boss.count(e -> true);
	}
	
	
	//method get size by gender
	@Override
	public int getSizeByGender(Gender gender) {
		return boss.count(e -> e.getGender() == gender);
	}
	
	
	//method to return names of all employees
	@Override
	public List<String> allEmployees(){
		List<String> names = new ArrayList<>();
		List<Employee> employees = boss.toList();
		for (Employee e : employees) {
			names.add(e.getName());			
		}
		return names;
	}
	
	
	
	
	
}
