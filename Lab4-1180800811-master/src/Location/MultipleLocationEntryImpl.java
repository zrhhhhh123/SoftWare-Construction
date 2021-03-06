package Location;

// a immutable class 多个位置及其对应的时间
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultipleLocationEntryImpl implements MultipleLocationEntry  {
	
	//AI:
	//all the value of the locations is not null 
	//the size of locations > 2
	//
	
	//Abstraction function:
	//代表多个位置
	//每个位置是确定的
	//	
	//Safety from rep exposure:
	// the field is private
	// List is immutable so getLocation make defensive copy
	//
	private List<Location> locations  = new ArrayList<Location>();//多个位置的列表
	

	
	
	public void checkRep() {
		assert locations != null ;
		assert locations.size() != 0 ;
		Set<Location> l = new HashSet<>() ;
		for(Location loc : locations) {
			l.add(loc);
		}
		assert l.size() == locations.size() : "多个位置中不能有重复的位置" ;
	}
	@Override
	public boolean addLocation(Location loc) {
		assert loc != null : "加入的位置不能为空" ;
		if(!locations.contains(loc)) {
			locations.add(loc);
			checkRep();
			return true;
		}else {
			return false;
		}
	
	}
	/**
	 * 无参数构造器
	 */
	public MultipleLocationEntryImpl() {
		
	}
	
	/**
	 * 构造器
	 * @param locations 一系列位置
	 */
	public MultipleLocationEntryImpl(List<Location> locations) {
		super();
		this.locations = locations;
		checkRep();
	}
	
	/**
	 * 
	 * @param locations 一系列位置
	 */
	@Override
	public void setLocations(List<Location> locs) {
		List<Location> lc = new ArrayList<Location>() ;
		lc.addAll(locs);
		locations = lc ;
		checkRep();
	}


	@Override
	public List<Location> getLocation() {
		List<Location> l  = new ArrayList<Location>();//多个位置的列表
		l.addAll(locations);
		assert l != null ;
		return l ;
	}
	@Override
	public String toString() {
		return "locations=" + locations ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultipleLocationEntryImpl other = (MultipleLocationEntryImpl) obj;
		return locations.equals(other.locations);
	}

	
}
