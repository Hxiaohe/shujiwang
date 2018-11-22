package domain;

import java.util.List;

public class Book {
	private String  id;
	private String bookname;
	private String author;
	private String chaodai;
	private int zishu;
	private String lujing;
	public String getLujing() {
		return lujing;
	}
	public void setLujing(String lujing) {
		this.lujing = lujing;
	}
	public int getZishu() {
		return zishu;
	}
	public void setZishu(int zishu) {
		this.zishu = zishu;
	}
	private List<domain.Command> commands;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getChaodai() {
		return chaodai;
	}
	public void setChaodai(String chaodai) {
		this.chaodai = chaodai;
	}
	public List<domain.Command> getCommands() {
		return commands;
	}
	public void setCommands(List<domain.Command> commands) {
		this.commands = commands;
	}
}
