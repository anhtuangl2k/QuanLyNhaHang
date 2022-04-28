package com.tt.pojos;

import com.tt.pojos.Feedback;
import com.tt.pojos.Receipt;
import com.tt.pojos.Restaurant;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T12:38:55")
@StaticMetamodel(Weddinghall.class)
public class Weddinghall_ { 

    public static volatile SingularAttribute<Weddinghall, Short> deleteFlag;
    public static volatile SingularAttribute<Weddinghall, Feedback> feedback;
    public static volatile SingularAttribute<Weddinghall, Restaurant> iDRestaurant;
    public static volatile SingularAttribute<Weddinghall, String> lobby;
    public static volatile SingularAttribute<Weddinghall, Double> quantity;
    public static volatile SingularAttribute<Weddinghall, String> shift;
    public static volatile SingularAttribute<Weddinghall, Integer> id;
    public static volatile CollectionAttribute<Weddinghall, Receipt> receiptCollection;

}