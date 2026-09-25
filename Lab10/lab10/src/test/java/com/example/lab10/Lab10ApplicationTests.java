package com.example.lab10;

import com.example.lab10.model.Product;
import com.example.lab10.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

/**
 * Lab10ApplicationTests — ทดสอบ Reactive code
 *
 * ✅ test findById() ทำเสร็จแล้วเป็นตัวอย่าง
 * ❌ TODO: เพิ่ม test สำหรับ method ที่นักศึกษาทำเอง
 *
 * StepVerifier — วิธีทดสอบ Mono/Flux:
 * StepVerifier.create(mono/flux)
 * .expectNext(value) ← คาดหวังค่าที่ได้
 * .expectNextCount(n) ← คาดหวังจำนวน element
 * .verifyComplete() ← ยืนยัน onComplete
 * .verifyError() ← ยืนยัน onError
 */
@SpringBootTest
class Lab10ApplicationTests {

	@Autowired
	private ProductRepository repository;

	// ══════════════════════════════════════════════════════
	// ✅ ตัวอย่าง test — ศึกษาแล้วเพิ่ม test เอง
	// ══════════════════════════════════════════════════════

	@Test
	void contextLoads() {
		// Spring Application Context โหลดสำเร็จ
	}

	@Test
	void testFindById_found() {
		// ✅ ตัวอย่าง: ทดสอบ findById ที่พบข้อมูล
		StepVerifier.create(repository.findById("1"))
				.expectNextMatches(p -> p.getName().contains("iPhone"))
				.verifyComplete();
	}

	@Test
	void testFindById_notFound() {
		// ✅ ตัวอย่าง: ทดสอบ findById ที่ไม่พบข้อมูล
		StepVerifier.create(repository.findById("999"))
				.verifyComplete(); // Mono.empty() → onComplete ทันที
	}

	// ══════════════════════════════════════════════════════
	// ❌ TODO: เพิ่ม test ด้านล่างนี้
	// ══════════════════════════════════════════════════════

	@Test
	void testFindAll() {
		// TODO: ทดสอบว่า findAll() คืน Flux ที่มี element
		// Hint: StepVerifier.create(repository.findAll())
		// .expectNextCount(3) ← มี 3 รายการ
		// .verifyComplete()
		StepVerifier.create(repository.findAll())
				.expectNextCount(3)
				.verifyComplete();
	}

	@Test
	void testSave() {
		Product newProduct = new Product("999", "Sony WH-1000XM5",
				"Electronics", "Sony", 10, 8000.0, "NONE");

		StepVerifier.create(repository.save(newProduct))
				.expectNextMatches(product -> "999".equals(product.getId()) &&
						"Sony WH-1000XM5".equals(product.getName()))
				.verifyComplete();
	}

	@Test
	void testFindByCategory() {
		StepVerifier.create(repository.findByCategory("Electronics"))
				.expectNextCount(3)
				.verifyComplete();
	}
}