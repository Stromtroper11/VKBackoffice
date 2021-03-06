package com.vk.backoffice.qr.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.http.util.ByteArrayBuffer;

@Entity
@Table(name = "rv_kyc")
public class RVUserKyc {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="mobileNumber")
	private String mobileNumber;
	
	@Column(name="panCardStatus")
	private String panCardStatus;

	public Byte[] getPanCardEncodedImage() {
		return panCardEncodedImage;
	}

	public void setPanCardEncodedImage(Byte[] panCardEncodedImage) {
		this.panCardEncodedImage = panCardEncodedImage;
	}

	public Byte[] getAdharCardEncodedImage() {
		return adharCardEncodedImage;
	}

	public void setAdharCardEncodedImage(Byte[] adharCardEncodedImage) {
		this.adharCardEncodedImage = adharCardEncodedImage;
	}

	public Byte[] getUserProfileImage() {
		return userProfileImage;
	}

	public void setUserProfileImage(Byte[] userProfileImage) {
		this.userProfileImage = userProfileImage;
	}

	@Column(name="panCardEncodedImage")
	private Byte[] panCardEncodedImage;
	
	@Column(name="adharCardStatus")
	private String adharCardStatus;
	
	@Column(name="adharCardEncodedImage")
	private Byte[] adharCardEncodedImage;
	
	@Column(name="userProfile")
	private String userProfileStatus;
	
	@Column(name="userProfileImage")
	private Byte[] userProfileImage;



	public RVUserKyc() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getPanCardStatus() {
		return panCardStatus;
	}



	public void setPanCardStatus(String panCardStatus) {
		this.panCardStatus = panCardStatus;
	}





	public String getAdharCardStatus() {
		return adharCardStatus;
	}



	public void setAdharCardStatus(String adharCardStatus) {
		this.adharCardStatus = adharCardStatus;
	}






	public String getUserProfileStatus() {
		return userProfileStatus;
	}



	public void setUserProfileStatus(String userProfileStatus) {
		this.userProfileStatus = userProfileStatus;
	}



	@Override
	public String toString() {
		return "RVUserKyc [id=" + id + ", mobileNumber=" + mobileNumber + ", panCardStatus=" + panCardStatus
				+ ", panCardEncodedImage=" + panCardEncodedImage + ", adharCardStatus=" + adharCardStatus
				+ ", adharCardEncodedImage=" + adharCardEncodedImage + ", userProfileStatus=" + userProfileStatus
				+ ", userProfileImage=" + userProfileImage + "]";
	}



	public  RVUserKyc(String panCardStatus,String adharCardStatus,String userProfileImageStatus ) {
		this.adharCardStatus =adharCardStatus;
		this.panCardStatus = panCardStatus;
		this.userProfileStatus= userProfileImageStatus;
	}
	
	
		
	
	
	
}
