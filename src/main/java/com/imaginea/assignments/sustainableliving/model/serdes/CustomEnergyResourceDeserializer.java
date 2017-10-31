package com.imaginea.assignments.sustainableliving.model.serdes;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imaginea.assignments.sustainableliving.model.*;

import java.io.IOException;

public class CustomEnergyResourceDeserializer extends JsonDeserializer<EnergyResource> {

  @Override
  public EnergyResource deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
    ObjectNode node = mapper.readTree(jsonParser);
    if (node.has("unit")) {
      ResourceConsumptionUnit actualUnit =
          ResourceConsumptionUnit.valueOf(node.get("unit").asText());
      switch (actualUnit) {
        case WATTS:
          return mapper.readValue(jsonParser, ElectricityResource.class);
        case LITRES:
          return mapper.readValue(jsonParser, WaterResource.class);
        case KILOGRAMS:
          return mapper.readValue(jsonParser, LpgResource.class);
      }
    }
    throw new IOException("Unable to deserialize unknown Resource type.");
  }
}
