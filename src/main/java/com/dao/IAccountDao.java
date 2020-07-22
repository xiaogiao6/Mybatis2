package com.dao;

import com.domain.Account;
import com.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    List<AccountUser> findAllAccount();
}
