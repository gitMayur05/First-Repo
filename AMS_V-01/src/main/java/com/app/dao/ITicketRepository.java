package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer>
{

}
