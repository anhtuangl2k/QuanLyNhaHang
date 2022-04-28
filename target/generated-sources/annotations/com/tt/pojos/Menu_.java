package com.tt.pojos;

import com.tt.pojos.ReceiptMenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T13:52:29")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> unit;
    public static volatile SingularAttribute<Menu, String> dish;
    public static volatile SingularAttribute<Menu, Double> price;
    public static volatile SingularAttribute<Menu, Integer> id;
    public static volatile SingularAttribute<Menu, Integer> type;
    public static volatile SingularAttribute<Menu, Short> deteleFlag;
    public static volatile CollectionAttribute<Menu, ReceiptMenu> receiptMenuCollection;
    public static volatile SingularAttribute<Menu, String> status;

}