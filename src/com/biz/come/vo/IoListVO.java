package com.biz.come.vo;

public class IoListVO {

	private String strDate;      // 거래일자
	private int intIO;           // 거래구분
	private String strCName;     // 상품명
	private int intPrice;        // 단가
	private int intQuan;         // 수량

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public int getIntIO() {
		return intIO;
	}

	public void setIntIO(int intIO) {
		this.intIO = intIO;
	}

	public String getStrCName() {
		return strCName;
	}

	public void setStrCName(String strCName) {
		this.strCName = strCName;
	}

	public int getIntPrice() {
		return intPrice;
	}

	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	public int getIntQuan() {
		return intQuan;
	}

	public void setIntQuan(int intQuan) {
		this.intQuan = intQuan;
	}

	@Override
	public String toString() {
		return "IoListVO [strDate=" + strDate + ", intIO=" + intIO + ", strCName=" + strCName + ", intPrice=" + intPrice
				+ ", intQuan=" + intQuan + "]";
	}

}
