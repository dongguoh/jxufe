/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.gjx.struts.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Information;
import com.gjx.util.*;

public class DeleteFileAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String path = servlet.getServletContext().getRealPath("/");
		Information inf = null;
		String filePath = null;
		String forward="success";
		int id = 0;

		id = Integer.parseInt(request.getParameter("id"));

		if (id == -1) {
			filePath = path
					+ (String) request.getSession().getAttribute(
							Constants.UPLOAD_PATH);
			request.getSession().removeAttribute(Constants.UPLOAD_PATH);
		} else {
			inf = Factory.getInfromationDaoImple().getInformation(id);
			filePath = path + inf.getFile();
		}

		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			if (file.delete()) {

				if (inf != null) {
					System.out.println("��Ϣ��¼ɾ���ɹ�,�ļ���Ϊ:" + inf.getFile());
					inf.setFile(null);
					Factory.getInfromationDaoImple().updateInformation(inf);
					request.setAttribute(Constants.INFORMATION_KEY, inf);
					forward=Constants.SUCCESS_KEY;
				} else {
					System.out.println("*******�ļ�ɾ���ɹ�,�ļ���Ϊ:");
					forward="success2";
				}

			}

		}
		return mapping.findForward(forward);
	}
}