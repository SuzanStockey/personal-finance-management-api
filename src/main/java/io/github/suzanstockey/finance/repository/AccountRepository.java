package io.github.suzanstockey.finance.repository;

import io.github.suzanstockey.finance.model.Account;
import io.github.suzanstockey.finance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUser(User user);
}
