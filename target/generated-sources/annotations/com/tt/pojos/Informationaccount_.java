package com.tt.pojos;

import com.tt.pojos.Account;
import com.tt.pojos.Feedback;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T13:52:29")
@StaticMetamodel(Informationaccount.class)
public class Informationaccount_ { 

    public static volatile SingularAttribute<Informationaccount, String> gmail;
    public static volatile SingularAttribute<Informationaccount, Feedback> feedback;
    public static volatile SingularAttribute<Informationaccount, String> address;
    public static volatile SingularAttribute<Informationaccount, String> phone;
    public static volatile SingularAttribute<Informationaccount, Integer> id;
    public static volatile SingularAttribute<Informationaccount, String> userName;
    public static volatile SingularAttribute<Informationaccount, Account> iDAccount;

}