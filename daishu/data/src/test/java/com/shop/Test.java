package com.shop;

public class Test {
	public static void main(String[] args) {
		String s = "changgui_1,changgui_2,changgui_3,changgui_4,changgui_5,changgui_6,changgui_7,jingxibaojie_1,jingxibaojie_2,jingxibaojie_3,jingxibaojie_4,jingxibaojie_5,jingxibaojie_6,jingxibaojie_7,caboli_1,caboli_2,caboli_3,caboli_4,caboli_5,caboli_6,caboli_7,ganxi_1,ganxi_2,ganxi_3,ganxi_4,ganxi_5,ganxi_6,ganxi_7,shendubaojie_1,shendubaojie_2,shendubaojie_3,shendubaojie_4,shendubaojie_5,shendubaojie_6,shendubaojie_7,xinjukaihuang_1,xinjukaihuang_2,xinjukaihuang_3,xinjukaihuang_4,xinjukaihuang_5,xinjukaihuang_6,xinjukaihuang_7,jiajuhuli_1,jiajuhuli_2,jiajuhuli_3,jiajuhuli_4,jiajuhuli_5,jiajuhuli_6,jiajuhuli_7,jiadianqingxi_1,jiadianqingxi_2,jiadianqingxi_3,jiadianqingxi_4,jiadianqingxi_5,jiadianqingxi_6,jiadianqingxi_7";
		String ss[] = s.split(",");
		int i=1;
		for(String str:ss){
			System.out.println("<td style=\"width:12.5%\">");
			System.out.println("<a class=\"editable_item\" href=\"javascript:;\" data-type=\"text\" data-pk=\"recruitment_url\" data-original-title=\"人数\">${schedule." + str + "}");
			System.out.println("</td>");
			if(i%7==0){
				System.out.println("#########");
			}
			i++;
		}
	}
}
