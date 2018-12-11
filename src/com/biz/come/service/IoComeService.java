package com.biz.come.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.come.vo.IoListVO;

public class IoComeService {

	List<IoListVO> ioList;
	String strFileName;

	public IoComeService(String strFileName) {
		ioList = new ArrayList();
		this.strFileName = strFileName;
	}

	public void readFile() {
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(this.strFileName);
			buffer = new BufferedReader(fr);

			while (true) {
				String strRead = buffer.readLine();
				if (strRead == null)
					break;
				String[] strSp = strRead.split(":");

				IoListVO vo = new IoListVO();

				vo.setStrDate(strSp[0]);
				vo.setStrCName(strSp[1]);
				vo.setIntIO(Integer.valueOf(strSp[2]));
				vo.setIntPrice(Integer.valueOf(strSp[3]));
				vo.setIntQuan(Integer.valueOf(strSp[4]));

				ioList.add(vo);

			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showList() {
		System.out.println("====================================================================================");
		System.out.println("거래일자\t구분\t상품명\t\t단가\t수량\t매입금액\t매출금액");
		System.out.println("------------------------------------------------------------------------------------");
		int intSize = ioList.size();
		int intIs = 0;
		int intOs = 0;

		for (int i = 0; i < intSize; i++) {

			String strIO;
			int intGaI = 0;
			int intGaO = 0;

			if (ioList.get(i).getIntIO() == 0) {
				intGaI = ioList.get(i).getIntPrice() * ioList.get(i).getIntQuan();
				strIO = "매입";
				
			} else {
				intGaO = ioList.get(i).getIntPrice() * ioList.get(i).getIntQuan();
				strIO = "매출";
				
			}
			intIs += intGaI;
			intOs += intGaO;
			System.out.println(ioList.get(i).getStrDate() + "\t" + ioList.get(i).getIntIO() + "(" + strIO + ")" + "\t"
					+ ioList.get(i).getStrCName() + "\t" + ioList.get(i).getIntPrice() + "\t"
					+ ioList.get(i).getIntQuan() + "\t" + intGaI + "\t\t" + intGaO);
		}
		System.out.println("====================================================================================");
		System.out.println("총합" + "\t\t\t\t\t\t\t" + intIs + "원" + "\t" + intOs + "원");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("이익금" + "\t\t\t\t\t\t\t\t\t" + (intOs - intIs) + "원");
		System.out.println("====================================================================================");
	}

}
