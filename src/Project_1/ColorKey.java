package Project_1;

import java.util.Objects;

/**
 * Color Key for the Simulator View HashMap of colors for classes
 */
public class ColorKey {
    private Class animalClass;
    private Class virusClass;

    public ColorKey(Class animalClass, Class virusClass) {
        this.animalClass = animalClass;
        this.virusClass = virusClass;
    }
    public Class getAnimalClass() {
        return animalClass;
    }

    public Class getVirusClass() {
        return virusClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorKey colorKey = (ColorKey) o;
        return Objects.equals(animalClass, colorKey.animalClass) && Objects.equals(virusClass, colorKey.virusClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalClass, virusClass);
    }
}
