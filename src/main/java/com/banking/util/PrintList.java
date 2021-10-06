package com.banking.util;

import com.banking.dao.BankAccountsDao;
import com.banking.models.BankAccounts;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PrintList extends BankAccountsDao {

    public static String customFormat(double value) {
        DecimalFormat myFormatter = new DecimalFormat("###,###.###");
        String output = myFormatter.format(value);
        return (output);
    }




    public static void PrintAccount(int id) {
        BankAccountsDao dao = new BankAccountsDao();


        List<BankAccounts> AccountList = dao.findAll();
        int i = 0;
        while(i < AccountList.size()){
            BankAccounts tempaccount = AccountList.get(i);
            if(tempaccount.getAccountOwner() == id){
                System.out.println("id " + tempaccount.getId()+ " balance $"+ customFormat(tempaccount.getBalance()));
            }
            i++;
        }


    }
}





