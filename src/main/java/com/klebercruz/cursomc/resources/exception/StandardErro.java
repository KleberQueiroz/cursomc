package com.klebercruz.cursomc.resources.exception;

import java.io.Serializable;

public class StandardErro  implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String erro;
	private Long timeStamp;
	
	public StandardErro(Integer status, String erro, Long timeStamp) {
		super();
		this.status = status;
		this.erro = erro;
		this.timeStamp = timeStamp;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
