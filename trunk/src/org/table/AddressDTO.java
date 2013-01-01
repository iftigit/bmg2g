package org.table;


public class AddressDTO {

	private int division_id;
	private String division_name;
	
	private String district_code;
	private int district_id;
	private String district_name;
	
	private String thana_id;
	private String thana_name;

	private String union_id;
	private String union_name;

	
	private String pDivision="";
	private String pDivisionName="";
	
	private String pDistrict="";
	private String pDistrictName="";
	private String pThana="";
	private String pThanaName="";
	private String pUnion="";
	private String pUnionName="";

	
	
	private String pPost="";
	private String pPostCode="";
	private String pEmail="";
	private String pMobile="";
	private String sameAsPermanenet="";
	
	private String mDivision="";
	private String mDivisionName="";
	private String mDistrict="";
	private String mDistrictName="";
	private String mThana="";
	private String mThanaName="";
	private String mUnion="";
	private String mUnionName="";

	private String mPost="";
	private String mPostCode="";
	private String mEmail="";
	private String mMobile="";
	
	private String pAddressLine1;
	private String pAddressLine2;
	
	private String mAddressLine1;
	private String mAddressLine2;
	
	
	
	public int getDivision_id() {
		return division_id;
	}
	public void setDivision_id(int divisionId) {
		division_id = divisionId;
	}
	public String getDivision_name() {
		return division_name;
	}
	public void setDivision_name(String divisionName) {
		division_name = divisionName;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int districtId) {
		district_id = districtId;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String districtName) {
		district_name = districtName;
	}
	
	public String getThana_id() {
		return thana_id;
	}
	public void setThana_id(String thanaId) {
		thana_id = thanaId;
	}
	public String getThana_name() {
		return thana_name;
	}
	public void setThana_name(String thanaName) {
		thana_name = thanaName;
	}
	public String getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(String districtCode) {
		district_code = districtCode;
	}
	public String getpDivision() {
		return pDivision;
	}
	public void setpDivision(String pDivision) {
		this.pDivision = pDivision;
	}
	public String getpDistrict() {
		return pDistrict;
	}
	public void setpDistrict(String pDistrict) {
		this.pDistrict = pDistrict;
	}
	public String getpThana() {
		return pThana;
	}
	public void setpThana(String pThana) {
		this.pThana = pThana;
	}
	public String getpPost() {
		return pPost;
	}
	public void setpPost(String pPost) {
		this.pPost = pPost;
	}
	public String getpEmail() {
		return pEmail;
	}
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}
	public String getpMobile() {
		return pMobile;
	}
	public void setpMobile(String pMobile) {
		this.pMobile = pMobile;
	}
	public String getMDivision() {
		return mDivision;
	}
	public void setMDivision(String mDivision) {
		this.mDivision = mDivision;
	}
	public String getmDistrict() {
		return mDistrict;
	}
	public void setmDistrict(String mDistrict) {
		this.mDistrict = mDistrict;
	}
	public String getmThana() {
		return mThana;
	}
	public void setmThana(String mThana) {
		this.mThana = mThana;
	}
	public String getmPost() {
		return mPost;
	}
	public void setmPost(String mPost) {
		this.mPost = mPost;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmMobile() {
		return mMobile;
	}
	public void setmMobile(String mMobile) {
		this.mMobile = mMobile;
	}
	public String getpPostCode() {
		return pPostCode;
	}
	public void setpPostCode(String pPostCode) {
		this.pPostCode = pPostCode;
	}
	public String getmPostCode() {
		return mPostCode;
	}
	public void setmPostCode(String mPostCode) {
		this.mPostCode = mPostCode;
	}
	public String getpDivisionName() {
		return pDivisionName;
	}
	public void setpDivisionName(String pDivisionName) {
		this.pDivisionName = pDivisionName;
	}
	public String getpDistrictName() {
		return pDistrictName;
	}
	public void setpDistrictName(String pDistrictName) {
		this.pDistrictName = pDistrictName;
	}
	public String getpThanaName() {
		return pThanaName;
	}
	public void setpThanaName(String pThanaName) {
		this.pThanaName = pThanaName;
	}
	public String getmDivision() {
		return mDivision;
	}
	public void setmDivision(String mDivision) {
		this.mDivision = mDivision;
	}
	public String getmDivisionName() {
		return mDivisionName;
	}
	public void setmDivisionName(String mDivisionName) {
		this.mDivisionName = mDivisionName;
	}
	public String getmDistrictName() {
		return mDistrictName;
	}
	public void setmDistrictName(String mDistrictName) {
		this.mDistrictName = mDistrictName;
	}
	public String getmThanaName() {
		return mThanaName;
	}
	public void setmThanaName(String mThanaName) {
		this.mThanaName = mThanaName;
	}
	public String getSameAsPermanenet() {
		return sameAsPermanenet;
	}
	public void setSameAsPermanenet(String sameAsPermanenet) {
		this.sameAsPermanenet = sameAsPermanenet;
	}
	public String getpAddressLine1() {
		return pAddressLine1;
	}
	public void setpAddressLine1(String pAddressLine1) {
		this.pAddressLine1 = pAddressLine1;
	}
	public String getpAddressLine2() {
		return pAddressLine2;
	}
	public void setpAddressLine2(String pAddressLine2) {
		this.pAddressLine2 = pAddressLine2;
	}
	public String getmAddressLine1() {
		return mAddressLine1;
	}
	public void setmAddressLine1(String mAddressLine1) {
		this.mAddressLine1 = mAddressLine1;
	}
	public String getmAddressLine2() {
		return mAddressLine2;
	}
	public void setmAddressLine2(String mAddressLine2) {
		this.mAddressLine2 = mAddressLine2;
	}
	public String getUnion_id() {
		return union_id;
	}
	public void setUnion_id(String union_id) {
		this.union_id = union_id;
	}
	public String getUnion_name() {
		return union_name;
	}
	public void setUnion_name(String union_name) {
		this.union_name = union_name;
	}
	public String getPUnion() {
		return pUnion;
	}
	public void setPUnion(String union) {
		pUnion = union;
	}
	public String getPUnionName() {
		return pUnionName;
	}
	public void setPUnionName(String unionName) {
		pUnionName = unionName;
	}
	public String getMUnion() {
		return mUnion;
	}
	public void setMUnion(String union) {
		mUnion = union;
	}
	public String getMUnionName() {
		return mUnionName;
	}
	public void setMUnionName(String unionName) {
		mUnionName = unionName;
	}
	
	
	
}
