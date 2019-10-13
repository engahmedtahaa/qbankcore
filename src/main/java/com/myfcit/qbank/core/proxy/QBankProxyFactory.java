/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.proxy;

import com.myfcit.qbank.core.dals.BaseDal;


public class QBankProxyFactory {

    QBankServiceableProxy qbankServiceableProxy;

    public QBankServiceableProxy newInstance() {
        BaseDal baseDal = BaseDal.getInstance();
        return qbankServiceableProxy = QBankServiceProxy.createServiceInstance(new QBankServiceProxyImpl(baseDal.getEntityManager()));
    }

}
