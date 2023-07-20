package com.utk.azurecloud.respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.utk.azurecloud.dto.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
