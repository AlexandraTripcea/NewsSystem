package logic;
import java.util.Date;

import listener.Editor;

public class Article {
	String domain, title, info_source;
	Date published, modified; 
	Editor editor;
	
	public Article(Editor editor, String title, String domain) {
		this.editor = editor;
		this.domain = domain;
		this.title = title; 
		this.published = new Date(System.currentTimeMillis());
	}
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo_source() {
		return info_source;
	}

	public void setInfo_source(String info_source) {
		this.info_source = info_source;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}
}
