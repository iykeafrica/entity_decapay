package com.example.decapay.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Ikechi Ucheagwu
 * @created 09/12/2022 - 5:09 PM
 * @project DECAPAY
 */

@Getter
@Setter
@Entity(name = "category_tb")
@SQLDelete(sql = "UPDATE category_tb SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Category extends BaseEntity{
    private String name;

    @ManyToOne()
    @JoinColumn(name = "user_tb_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "line_item_tb_id")
    private LineItem lineItem;
}
