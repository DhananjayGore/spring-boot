package in.dhananjaygore.expensetrackerapi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "expense_name")
	private String name;

	private String description;

	@Column(name = "expense_amount")
	private BigDecimal amount;
	
	private String category;

	private Date date;
	
	@Column(name="created_at", nullable=false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

	public long getId() {
		return id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", category=" + category + ", date=" + date
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, category, createdAt, date, description, id, name, updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(category, other.category)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(date, other.date)
				&& Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(updatedAt, other.updatedAt);
	}

}