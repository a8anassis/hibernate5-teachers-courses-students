package gr.aueb.cf.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public abstract class AbstractEntity extends IdentifiableEntity implements Serializable {

    @ColumnDefault("true")
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
