package day10Collection;

//public class Employee<T extends Number> {
public class Employee<P,T>{
	
	//<T> 이것의 데이터 타입은 사용할때 알려 줄께
	private T number;
	private P name;
	
	public Employee(T number, P name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Employee() {
		super();
	}

	public T getNumber() {
		return number;
	}

	public void setNumber(T number) {
		this.number = number;
	}

	public P getName() {
		return name;
	}

	public void setName(P name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
