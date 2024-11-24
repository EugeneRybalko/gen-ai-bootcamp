### Module 2 Results
POST http://localhost:8080/ai/semantic

Temperature default 1.0
```json
{
    "input": "Act as a poet"
}
```
```json
{
    "messages": [
        "As shadows cast by candle flame at night,\nI weave the tapestries of dreams and thought.\nA poet's heart, a scribe of deep insight,\nWhere words become the art that's gently wrought.\n\nIn every line, a subtle truth I seek,\nOn whispered breeze, through leaves of old oak trees.\nEach stanza holds a power, strong yet meek,\nTo stir the soul, to bring us to our knees.\n\nA verse can cry the tears of deepest woe,\nOr sing the joys that dance on morning light.\nWith every rhythm, letting heartbeats flow,\nI capture life, in hues of black and white.\n\nSo, let us journey through this inky maze,\nWhere poets dwell, in silent, starlit grace."
    ]
}
```
```json
{
    "input": "Write a short poem in 4 sentences"
}
```
```json
{
    "messages": [
        "In the quiet blue of a crisp dawn sky,\nWhispers of morning stir the sleepy land.\nSun-kissed petals unfold, shyly sigh,\nAs day awakens with a gentle hand."
    ]
}
```
```json
{
    "input": "Show our chat history"
}
```
```json
{
    "messages": [
        "Here's the summary of our chat history:\n\n1. You asked me to act as a poet.\n2. I responded with a poetic paragraph.\n3. You requested a short poem in 4 sentences, which I provided.\n4. You asked to see our chat history.\n\nIf you need more details or further assistance, feel free to ask!"
    ]
}
```
Chat history example
```xml
<messages>
<message role="user">Act as a poet</message>
<message role="assistant">As shadows cast by candle flame at night,
I weave the tapestries of dreams and thought.
A poet&apos;s heart, a scribe of deep insight,
Where words become the art that&apos;s gently wrought.

In every line, a subtle truth I seek,
On whispered breeze, through leaves of old oak trees.
Each stanza holds a power, strong yet meek,
To stir the soul, to bring us to our knees.

A verse can cry the tears of deepest woe,
Or sing the joys that dance on morning light.
With every rhythm, letting heartbeats flow,
I capture life, in hues of black and white.

So, let us journey through this inky maze,
Where poets dwell, in silent, starlit grace.</message>
<message role="user">Write a short poem in 4 sentences</message>
<message role="assistant">In the quiet blue of a crisp dawn sky,
Whispers of morning stir the sleepy land.
Sun-kissed petals unfold, shyly sigh,
As day awakens with a gentle hand.</message>
</messages>
<message role="user">Show our chat history</message>
```


Temperature 2.0
```json
{
    "input": "Act as a poet"
}
```
```json
{
    "messages": [
        "Of course! I'd be happy to express in verse. What theme or subject would you like the poem to be about?"
    ]
}
```
```json
{
    "input": "Write a short poem in 4 sentences"
}
```
```json
{
    "messages": [
        "Certainly! Here's a short poem:\n\nIn the quiet whisper of the dawn,\nThe sky paints shades of a hopeful morn.\nEach breath a promise, softly sworn,\nTo cherish moments, newly born."
    ]
}
```
```json
{
    "input": "Show our chat history"
}
```
```json
{
    "messages": [
        "Here's a summary of our chat history:\n\n1. **You asked:** Act as a poet\n2. **I responded:** Of course! I'd be happy to express in verse. What theme or subject would you like the poem to be about?\n\n3. **You requested:** Write a short poem in 4 sentences\n4. **I provided:** A short poem:\n   *In the quiet whisper of the dawn,*\n   *The sky paints shades of a hopeful morn.*\n   *Each breath a promise, softly sworn,*\n   *To cherish moments, newly born.* \n\n5. **You asked:** Show our chat history\n6. **I provided:** A summary of our chat history (this current response).\n\nFeel free to ask anything else or give further instructions!"
    ]
}
```
Chat history
```xml
<messages>
<message role="user">Act as a poet</message>
<message role="assistant">Of course! I&apos;d be happy to express in verse. What theme or subject would you like the poem to be about?</message>
<message role="user">Write a short poem in 4 sentences</message>
<message role="assistant">Certainly! Here&apos;s a short poem:

In the quiet whisper of the dawn,
The sky paints shades of a hopeful morn.
Each breath a promise, softly sworn,
To cherish moments, newly born.</message>
</messages>
<message role="user">Show our chat history</message>
```

### Module 1 Results
POST http://localhost:8080/ai/semantic
```json
{
    "input": "Act as software engineer"
}
```
```json
{
    "messages": [
        "As a software engineer, I'm here to assist you with any technical issues, programming advice, code reviews, or development of algorithms. How can I help you today?"
    ]
}
```
```json
{
    "input": "Which role I have defined for you ?"
}
```
```json
{
    "messages": [
        "You have defined my role as a software engineer, ready to assist with any technical issues, programming guidance, code development, or any related tasks."
    ]
}
```
```json
{
    "messages": [
        "As a virtual assistant acting as a software engineer, here are some design patterns I'm familiar with:\n\n1. **Creational Patterns:**\n   - Singleton\n   - Factory Method\n   - Abstract Factory\n   - Builder\n   - Prototype\n\n2. **Structural Patterns:**\n   - Adapter (or Wrapper)\n   - Composite\n   - Proxy\n   - Flyweight\n   - Facade\n   - Bridge\n   - Decorator\n\n3. **Behavioral Patterns:**\n   - Strategy\n   - Observer\n   - Command\n   - Iterator\n   - Template Method\n   - Chain of Responsibility\n   - State\n   - Mediator\n   - Memento\n   - Visitor\n\nThese design patterns help solve common problems in software design and improve the readability, flexibility, or scalability of the software. Each pattern addresses specific design issues, helping software engineers structure the code in ways that are efficient and maintainable. If you need details or examples on any specific pattern, feel free to ask!"
    ]
}
```
