package br.com.ferraz.improvemyself.defaults;

import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class DefaultService<T extends DefaultEntity> {

    private Class<T> clazz;
    private PagingAndSortingRepository<T, Integer> repository;


    public DefaultService(PagingAndSortingRepository<T, Integer> repository, Class<T> clazz) {
        this.repository = repository;
        this.clazz = clazz;
    }


    public T findById(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    public <I extends DefaultDto> void save(I dto) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            obj.load(dto);

            this.repository.save(obj);
        } catch (Exception e) {
            throw new RuntimeException("Unnable to save " + clazz.getName());
        }
    }

}