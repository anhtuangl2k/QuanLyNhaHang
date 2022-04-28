package com.tt.pojos;

import com.tt.pojos.ReceiptMenu;
import com.tt.pojos.Weddinghall;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T14:55:04")
@StaticMetamodel(Receipt.class)
public class Receipt_ { 

    public static volatile SingularAttribute<Receipt, Double> total;
    public static volatile SingularAttribute<Receipt, Weddinghall> iDWeddingHall;
    public static volatile SingularAttribute<Receipt, Integer> id;
    public static volatile CollectionAttribute<Receipt, ReceiptMenu> receiptMenuCollection;

}