package com.grow.agriculture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.dao.OTPDao;
import com.grow.agriculture.daoBean.OTP;
import com.grow.agriculture.helper.OTPHelper;
import com.grow.agriculture.service.OTPService;

public class OTPServiceImpl implements OTPService {

@Autowired
OTPDao otpdao;

@Autowired
OTPHelper helper;


@Override
public OTP retrive(long phoneNumber) {
	OTP otpDaoBean = otpdao.retrive(phoneNumber);
	return otpDaoBean != null && !otpDaoBean.toString().isEmpty() ? otpDaoBean : null ;
}

@Override
public void save(OTP otpDaoBean) {
	otpdao.save(otpDaoBean);
}

@Override
public void update(String columnname, String valuename, String phonenumber) {
	otpdao.update(columnname, valuename, phonenumber);
}

@Override
public void delete(int phonenumber) {
	otpdao.delete(phonenumber);
}

@Override
public int check(long phonenumber) {
	int count = otpdao.check(phonenumber);
	return count;
}
}
