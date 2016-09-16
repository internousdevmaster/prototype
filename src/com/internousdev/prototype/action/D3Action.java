package com.internousdev.prototype.action;

import com.internousdev.prototype.dao.D3DAO;
import com.internousdev.prototype.dto.D3DTO;
import com.opensymphony.xwork2.ActionSupport;

public class D3Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6441485542278017430L;
	public int countOld1;
	public int countOld2;
	public int countOld3;
	public int countOld4;
	public int countOld5;
	public int countOld6;
	public int countOld7;
	public int countOld8;
	public String execute() {
		D3DAO dao = new D3DAO();
		dao.d3Dao();
		D3DTO dto = dao.getDto();
		countOld1 = dto.getCountOld1();
		countOld2 = dto.getCountOld2();
		countOld3 = dto.getCountOld3();
		countOld4 = dto.getCountOld4();
		countOld5 = dto.getCountOld5();
		countOld6 = dto.getCountOld6();
		countOld7 = dto.getCountOld7();
		countOld8 = dto.getCountOld8();
		String result = SUCCESS;
		return result;
	}
}
