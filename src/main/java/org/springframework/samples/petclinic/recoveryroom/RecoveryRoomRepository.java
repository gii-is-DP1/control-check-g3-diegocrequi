package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
	List<RecoveryRoom> findAll();
    @Query(value = "SELECT rrt FROM RecoveryRoomType rrt")
    
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    Optional<RecoveryRoom> findById(int id);
    
    @Transactional
    RecoveryRoom save(RecoveryRoom p);
    
    @Query(value = "SELECT rrt FROM RecoveryRoomType rrt WHERE rrt.name = :name")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query(value = "SELECT rr FROM RecoveryRoom rr WHERE rr.size > :size")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
