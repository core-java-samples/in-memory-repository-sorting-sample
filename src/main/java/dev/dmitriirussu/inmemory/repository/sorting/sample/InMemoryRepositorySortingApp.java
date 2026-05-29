package dev.dmitriirussu.inmemory.repository.sorting.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

record Owner(Long id, String name) {}

interface OwnerRepository {
	List<Owner> findAll(Comparator<Owner> comparator);
}

class FakeOwnerRepository implements OwnerRepository {

	private final Map<Long, Owner> owners = new LinkedHashMap<>();

	public FakeOwnerRepository() {
		owners.put(1L, new Owner(1L, "jack1"));
		owners.put(2L, new Owner(2L, "jack2"));
		owners.put(3L, new Owner(3L, "jack3"));
		owners.put(4L, new Owner(4L, "jack4"));
		owners.put(5L, new Owner(5L, "jack5"));
	}

	@Override
	public List<Owner> findAll(Comparator<Owner> comparator) {

		Stream<Owner> stream = owners.values().stream();

		if (comparator != null) stream = stream.sorted(comparator);

		return stream.toList();
	}
}

@SpringBootApplication
public class InMemoryRepositorySortingApp {
	public static void main(String[] args) {
		SpringApplication.run(InMemoryRepositorySortingApp.class, args);
		new InMemoryRepositorySortingApp().demo();
	}
	void demo() {
		OwnerRepository repository = new FakeOwnerRepository();

		repository.findAll(Comparator.comparing(Owner::id)).forEach(System.out::println);;
		System.out.println();
		repository.findAll(Comparator.comparingLong(Owner::id).reversed()).forEach(System.out::println);;
		System.out.println();
		repository.findAll(null).forEach(System.out::println);
	}
}
