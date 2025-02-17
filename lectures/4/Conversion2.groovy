class Measurement {
    static final Map<String, Double> conversionFactors = [
        'inches': 1.0, 
        'feet': 12.0, 
        'yards': 36.0, 
        'miles': 63360.0,
        'cm': 0.393701, 
        'meters': 39.3701
    ]

    double value
    String unit

    Measurement(double value, String unit) {
        if (!conversionFactors.containsKey(unit)) {
            throw new IllegalArgumentException("Unknown unit: $unit")
        }
        this.value = value
        this.unit = unit
    }

    double toBase() {
        return value * conversionFactors[unit] // Convert to inches
    }

    Measurement convertTo(String targetUnit) {
        if (!conversionFactors.containsKey(targetUnit)) {
            throw new IllegalArgumentException("Unknown target unit: $targetUnit")
        }
        double baseValue = toBase()
        return new Measurement(baseValue / conversionFactors[targetUnit], targetUnit)
    }

    Measurement plus(Measurement other) {
        double totalBase = this.toBase() + other.toBase()
        return new Measurement(totalBase / conversionFactors[this.unit], this.unit)
    }

    Measurement minus(Measurement other) {
        double totalBase = this.toBase() - other.toBase()
        return new Measurement(totalBase / conversionFactors[this.unit], this.unit)
    }

    Measurement getFeet() {
        return this.convertTo("feet")
    }
    
    Measurement getInches() {
        return this.convertTo("inches")
    }
    
    Measurement getYards() {
        return this.convertTo("yards")
    }
    
    Measurement getMiles() {
        return this.convertTo("miles")
    }
    
    Measurement getCm() {
        return this.convertTo("cm")
    }
    
    Measurement getMeters() {
        return this.convertTo("meters")
    }

    String toString() {
        return "${value} ${unit}"
    }
}

// Extend Number class to support unit methods
Number.metaClass.getInches = { -> new Measurement(delegate, 'inches') }
Number.metaClass.getFeet = { -> new Measurement(delegate, 'feet') }
Number.metaClass.getYards = { -> new Measurement(delegate, 'yards') }
Number.metaClass.getMiles = { -> new Measurement(delegate, 'miles') }
Number.metaClass.getCm = { -> new Measurement(delegate, 'cm') }
Number.metaClass.getMeters = { -> new Measurement(delegate, 'meters') }

// Usage Examples
def result = 5.feet + 6.inches
println result  // Output: 5.5 feet

// Convert the result
def convertedResult = result.meters
println convertedResult  // Output: Converted value in meters

def result2 = 2.yards + 12.inches
println result2  // Output: 2.333 yards

def result21 = 2.yards - 12.inches
println result21  

def result3 = 1.miles + 500.feet
println result3.feet  // Output: 6050.0 feet
