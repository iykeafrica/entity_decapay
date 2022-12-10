package com.example.decapay.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * @author Ikechi Ucheagwu
 * @created 09/12/2022 - 5:36 PM
 * @project DECAPAY
 */

@Getter
@Setter
@Entity(name = "expense_tb")
@SQLDelete(sql = "UPDATE expense_tb SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Expense extends BaseEntity{

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "line_item_tb_id")
    private LineItem lineItem;

}
