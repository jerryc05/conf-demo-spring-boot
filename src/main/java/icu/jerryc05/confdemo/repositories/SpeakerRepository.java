package icu.jerryc05.confdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import icu.jerryc05.confdemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
