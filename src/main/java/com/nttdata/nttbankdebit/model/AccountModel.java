package com.nttdata.nttbankdebit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
public class AccountModel {
  @Id
  private String number;

  private float funds;

  private String debit;

  private int priority;
}
