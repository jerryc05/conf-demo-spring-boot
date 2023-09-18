package icu.jerryc05.confdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import icu.jerryc05.confdemo.models.Session;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
