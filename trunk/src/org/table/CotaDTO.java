package org.table;

public class CotaDTO {
	
	private String distname="";
	private String distid="";
	private float discota=0;
	private long total=0;
	
	public CotaDTO()
	{
		
	}
	
	
	public CotaDTO(String distname, String distid, float discota, long total) {
		super();
		this.distname = distname;
		this.distid = distid;
		this.discota = discota;
		this.total = total;
	}


	public String getDistname() {
		return distname;
	}
	public void setDistname(String distname) {
		this.distname = distname;
	}
	public String getDistid() {
		return distid;
	}
	public void setDistid(String distid) {
		this.distid = distid;
	}
	public float getDiscota() {
		return discota;
	}
	public void setDiscota(float discota) {
		this.discota = discota;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
	
}
