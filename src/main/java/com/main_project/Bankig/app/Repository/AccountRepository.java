package com.main_project.Bankig.app.Repository;

import com.main_project.Bankig.app.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
