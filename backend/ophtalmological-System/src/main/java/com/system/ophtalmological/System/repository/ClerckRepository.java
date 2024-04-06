package com.system.ophtalmological.System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.components.clerk.ClerkDocument;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Clerk;

@Repository
public interface ClerckRepository extends JpaRepository<Clerk, Long>{

	Optional<Clerk> findByCpf (String cpf);
	@Modifying
    @Query(value = "DELETE FROM department_clerk where department_id = :dpId AND clerk_id = :clerkId", nativeQuery = true)
	void deleteClerkFromDepartment(long clerkId, long dpId);
}
