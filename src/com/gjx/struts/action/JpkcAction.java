/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.gjx.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Jpkc;
import com.gjx.struts.form.JpkcForm;
import com.gjx.util.Constants;


public class JpkcAction extends DispatchAction {
	private static final Log logger = LogFactory.getLog(JpkcAction.class);

	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
logger.info("****请取JPKC的LIST（READ（））");
		List list = Factory.getJpkcDaoImpl().getJpkcList();		
		request.setAttribute(Constants.JPKC_LIST, list);
		logger.info("已经读取精品课程信息");
		return mapping.findForward(Constants.SUCCESS_KEY);

	}

	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		JpkcForm jf = (JpkcForm) form;
		Jpkc jpkc = new Jpkc();
		jpkc.setFullname(jf.getFullname());
		jpkc.setInfo(jf.getInfo());
		jpkc.setLevel(jf.getLevel());
		jpkc.setName(jf.getName());
		jpkc.setTeacher(jf.getTeacher());
		jpkc.setYear(jf.getYear());
		
		
		Factory.getJpkcDaoImpl().insertJpkc(jpkc);
		logger.info("已经插入一条Jpkc信息:"+jf.getName());
		List list = Factory.getJpkcDaoImpl().getJpkcList();
		request.setAttribute(Constants.JPKC_LIST, list);		
		request.setAttribute(Constants.SUCCESS_KEY,"");
		return mapping.findForward(Constants.SUCCESS_KEY);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Factory.getJpkcDaoImpl().deleteJpkc(id);
		List list = Factory.getJpkcDaoImpl().getJpkcList();
		request.setAttribute(Constants.JPKC_LIST, list);		
		logger.info("删除一条JPKC记录成功" + id);
		return mapping.findForward(Constants.SUCCESS_KEY);
	}

	// 更新
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		JpkcForm jf = (JpkcForm) form;
		Jpkc jpkc =Factory.getJpkcDaoImpl().getJpkc(id);
		
		jpkc.setFullname(jf.getFullname());
		jpkc.setInfo(jf.getInfo());
		jpkc.setLevel(jf.getLevel());
		jpkc.setName(jf.getName());
		jpkc.setTeacher(jf.getTeacher());
		jpkc.setYear(jf.getYear());
		
		Factory.getJpkcDaoImpl().updateJpkc(jpkc);

		logger.info("更新JPKC名称为：" + jpkc.getName());
		request.setAttribute("jpkc", jpkc);
		List list = Factory.getJpkcDaoImpl().getJpkcList();
		request.setAttribute(Constants.JPKC_LIST, list);
		request.setAttribute(Constants.SUCCESS_KEY,"");
		return mapping.findForward(Constants.SUCCESS_KEY);
	}

	// 取得一个linK
	public ActionForward getJpkc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		logger.info("找到要更改的Jpkc的ID:" + id);
		Jpkc jpkc = Factory.getJpkcDaoImpl().getJpkc(id);
		List list = Factory.getJpkcDaoImpl().getJpkcList();
		request.setAttribute(Constants.JPKC_LIST, list);
		request.setAttribute("jpkc", jpkc);
		return mapping.findForward(Constants.SUCCESS_KEY);
	}
}