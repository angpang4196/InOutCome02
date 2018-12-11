package com.biz.come;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InOutExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String strRead = "src/com/biz/come/iolist.txt";

		FileReader fr;
		BufferedReader buffer;

		String[] strSp;

		System.out.println("============================================================================================");
		System.out.print("거래일자\t상품명\t\t\t구분\t단가\t수량\t매입금액\t매출금액\n");
		System.out.println("--------------------------------------------------------------------------------------------");

		try {
			fr = new FileReader(strRead);
			buffer = new BufferedReader(fr);

			while (true) {
				String strR = buffer.readLine();

				if (strR == null)
					break;
				strSp = strR.split(":");

				int intInOut = Integer.valueOf(strSp[3]) * Integer.valueOf(strSp[4]);
				String strInOut = intInOut + "";

				if (strSp[2].equals("0")) {
					strSp[2] = "매입";
					if (strSp[1].length() >= 5) {
						System.out.print(strSp[0] + "\t" + strSp[1] + "\t\t" + strSp[2] + "\t" + strSp[3] + "\t"
								+ strSp[4] + "\t" + strInOut + "\n");
					} else {
						System.out.print(strSp[0] + "\t" + strSp[1] + "\t\t\t" + strSp[2] + "\t" + strSp[3] + "\t"
								+ strSp[4] + "\t" + strInOut + "\n");
					}
				} else if (strSp[2].equals("1")) {
					strSp[2] = "매출";
					if (strSp[1].length() >= 5) {
						System.out.print(strSp[0] + "\t" + strSp[1] + "\t\t" + strSp[2] + "\t" + strSp[3] + "\t"
								+ strSp[4] + "\t\t\t" + strInOut + "\n");
					} else {
						System.out.print(strSp[0] + "\t" + strSp[1] + "\t\t\t" + strSp[2] + "\t" + strSp[3] + "\t"
								+ strSp[4] + "\t\t\t" + strInOut + "\n");
					}
				}

			}

		}

		catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try문 end

	}

}
