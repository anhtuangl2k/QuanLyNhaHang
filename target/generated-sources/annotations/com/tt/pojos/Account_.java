package com.tt.pojos;

import com.tt.pojos.Informationaccount;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T12:38:55")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Short> deleteFlag;
    public static volatile CollectionAttribute<Account, Informationaccount> informationaccountCollection;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, Integer> typeAccount;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile SingularAttribute<Account, String> userID;

}