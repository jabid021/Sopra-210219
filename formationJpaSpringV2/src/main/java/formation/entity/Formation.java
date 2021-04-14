package formation.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import formation.validator.FormationDansLeFutur;

@Entity
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", initialValue = 100, allocationSize = 1)
@Table(name = "formation")
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	private Integer id;
	@Column(name = "date_formation")
	@FormationDansLeFutur
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFormation;
	@ManyToOne
	@JoinColumn(name = "id_formateur", foreignKey = @ForeignKey(name = "formation_id_formateur_fk"))
	private Formateur referent;
	@OneToMany(mappedBy = "id.formation")
	private Set<ModuleFormation> modules;
	@Version
	private int version;

	public Formation() {

	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(LocalDate dateFormation) {
		this.dateFormation = dateFormation;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	public Set<ModuleFormation> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleFormation> modules) {
		this.modules = modules;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
