/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.gjx.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 07-25-2007
 * 
 * XDoclet definition:
 * @struts.form name="informationForm"
 */
public class InformationForm extends ActionForm {
	private String title;
	private String content;
	private String issue;
	private int classify;
	private String file;
	public int getClassify() {
		return classify;
	}

	public void setClassify(int classify) {
		this.classify = classify;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors=new ActionErrors();
		if(null==this.title||this.title.length()<2){
			errors.add("errors",new ActionMessage("title.notempty"));
					
		}
		if(null==this.content||this.content.length()<5){
			errors.add("errors",new ActionMessage("content.noempty"));
		}
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
}