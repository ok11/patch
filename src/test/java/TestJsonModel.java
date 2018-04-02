import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.test.Patch;
import org.test.Patcheable;

import java.util.HashMap;
import java.util.Map;

public class TestJsonModel implements Patcheable {

    public static class Profile {
        private Integer age;
        private String email;

        public Profile() {}

        public Profile(Integer age, String email) {
            this.age = age;
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    private String name;
    private Profile profile;

    private Map<String, Object> attributes = new HashMap<>();

    public TestJsonModel() {}

    public TestJsonModel(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonAnyGetter
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void addAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    @Override
    public boolean validate(Patch.Operation operation) {
        return false;
    }

    @Override
    public boolean validate(Patch patch) {
        return false;
    }

    @Override
    public void apply(Patch.Operation operation) {

    }

    @Override
    public void apply(Patch patch) {

    }
}
