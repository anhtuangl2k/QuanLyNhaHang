package com.tt.pojos;

import com.tt.pojos.Informationaccount;
import com.tt.pojos.Weddinghall;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T13:52:29")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Informationaccount> informationaccount;
    public static volatile SingularAttribute<Feedback, Integer> iDWeddingHall;
    public static volatile SingularAttribute<Feedback, Weddinghall> weddinghall;
    public static volatile SingularAttribute<Feedback, String> comment;
    public static volatile SingularAttribute<Feedback, Integer> id;
    public static volatile SingularAttribute<Feedback, Integer> iDInformationAccount;

}