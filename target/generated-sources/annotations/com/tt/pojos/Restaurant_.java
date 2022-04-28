package com.tt.pojos;

import com.tt.pojos.Weddinghall;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T13:52:29")
@StaticMetamodel(Restaurant.class)
public class Restaurant_ { 

    public static volatile SingularAttribute<Restaurant, String> gmail;
    public static volatile SingularAttribute<Restaurant, Short> deleteFlag;
    public static volatile SingularAttribute<Restaurant, String> address;
    public static volatile SingularAttribute<Restaurant, String> phone;
    public static volatile SingularAttribute<Restaurant, String> restaurant;
    public static volatile CollectionAttribute<Restaurant, Weddinghall> weddinghallCollection;
    public static volatile SingularAttribute<Restaurant, Integer> id;

}