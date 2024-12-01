### Module 3 Results

#### 1. Retrieved list of available models
GET https://ai-proxy.lab.epam.com/openai/deployments <br>
Part of the response:
```json
{
  "data": [
    {
      "id": "dall-e-3",
      "model": "dall-e-3",
      "owner": "organization-owner",
      "object": "deployment",
      "status": "succeeded",
      "created_at": 1672534800,
      "updated_at": 1672534800,
      "scale_settings": {
        "scale_type": "standard"
      },
      "features": {
        "rate": false,
        "tokenize": false,
        "truncate_prompt": false,
        "configuration": false,
        "system_prompt": true,
        "tools": false,
        "seed": false,
        "url_attachments": false,
        "folder_attachments": false
      }
    },
    {
      "id": "gpt-35-turbo-0125",
      "model": "gpt-35-turbo-0125",
      "owner": "organization-owner",
      "object": "deployment",
      "status": "succeeded",
      "created_at": 1672534800,
      "updated_at": 1672534800,
      "scale_settings": {
        "scale_type": "standard"
      },
      "features": {
        "rate": false,
        "tokenize": false,
        "truncate_prompt": false,
        "configuration": false,
        "system_prompt": true,
        "tools": false,
        "seed": false,
        "url_attachments": false,
        "folder_attachments": false
      }
    }
  ]
}
```
#### 2. Testing model switching via request parameters
Endpoint for application testing http://localhost:8080/ai/semantic <br>
Using gpt-4o with temperature 0.7<br>
Request:
```json
{
    "input": "Describe a sunset.",
    "temperature": 0.7,
    "modelName": "gpt-4o",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        "A sunset is a daily natural spectacle where the sun appears to descend below the horizon, marking the transition from day to night. As the sun lowers in the sky, its light passes through more of Earth's atmosphere, which scatters shorter blue wavelengths and allows longer red, orange, and pink wavelengths to prevail. This scattering effect creates the vibrant and dynamic colors typically associated with sunsets.\n\nDuring a sunset, the sky often transforms into brilliant hues, beginning with gentle oranges and pinks that evolve into deeper reds, purples, and sometimes even rich golds. Clouds, if present, reflect the sunlight and add texture and contrast, enhancing the display with their varying shapes and intensities of color. The horizon provides a silhouette against the colorful backdrop, often featuring elements like trees, mountains, or buildings.\n\nAs the sun continues its descent, the light gradually fades, casting a tranquil and reflective atmosphere. This daily occurrence invites contemplation and appreciation of nature's beauty and serves as a reminder of the cyclical nature of time."
    ]
}
`<br><br>
Using Mixtral with temperature 0.7<br>
Request:
```json
{
    "input": "Describe a sunset.",
    "temperature": 0.7,
    "modelName": "Mixtral-8x7B-Instruct-v0.1",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        " As the day begins to wind down, the sun starts its slow descent towards the horizon, painting the sky with a breathtaking display of color and light. The once bright blue expanse begins to transform, taking on hues of pink, orange, and red, as if the heavens themselves are ablaze. The sun, now a fiery orb, casts long, dramatic shadows across the landscape, bathing the world in a warm, golden glow.\n\nThe clouds, once mere wisps in the sky, become canvas for the sun's dazzling artistry. They take on the colors of the sunset, creating a scene that is both surreal and awe-inspiring. The atmosphere seems to hum with a sense of tranquility, as if the world is holding its breath in anticipation of the coming night.\n\nAs the sun sinks lower, the colors deepen, becoming richer and more intense. The world is bathed in a soft, rosy light, casting everything in a gentle, flattering glow. The air cools, and a sense of calm washes over the landscape. The hustle and bustle of the day give way to a peaceful serenity, as the sun prepares to slip below the horizon.\n\nFinally, with a gentle sigh, the sun disappears from view, leaving behind a sky streaked with the last vestiges of its brilliant colors. The stars begin to twinkle in the twilight, and the world settles into the quiet, restful embrace of night. The sunset, with its dazzling display of light and color, serves as a gentle reminder of the beauty and wonder that can be found in even the simplest of moments."
    ]
}
`<br><br>

#### 3. Testing with different prompts and models
Using GPT-4o and temperature 0.2<br>
Request:
```json
{
    "input": "Explain quantum physics to a child.",
    "temperature": 0.2,
    "modelName": "gpt-4o",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        "Sure! Imagine you have a magical box of super tiny marbles that are so small, you can't see them. These marbles are called particles, and they're the building blocks of everything in the world, like your toys, your pet, and even you!\n\nNow, here's where the magic happens with these particles:\n\n1. **Surprising Shapes:** These tiny marbles can act really funny. Sometimes, they act like marbles, but other times, they act like waves on water. It's like they can be two things at once until you take a closer look!\n\n2. **Mystery Friends:** Imagine you have two magical marbles that are best friends. If you play with one marble, the other marble knows and reacts instantly, even if it’s far away. It’s like they can talk to each other secretly, no matter how far apart they are!\n\n3. **Peek-a-Boo Changes:** In the quantum world, just watching these tiny marbles can change what they do. It's like when you look at a jack-in-the-box, and every time you peek inside, the clown pops up in a different way!\n\nQuantum physics is the study of these magical, tiny marbles and their surprising behavior. Scientists learn so much from them, and they use this knowledge to make new inventions and technologies. Isn't that cool?"
    ]
}
`<br><br>
Using Mixtral and temperature 0.2<br>
Request:
```json
{
    "input": "Explain quantum physics to a child.",
    "temperature": 0.2,
    "modelName": "Mixtral-8x7B-Instruct-v0.1",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        " Alright! Let's imagine you have a magical box of tiny, magical dots that are too small to see, even with a microscope. These tiny dots are the building blocks of everything in the world, like your toys, your pet, and even you!\n\nNow, here's the magical part about these dots:\n\n1. **Shape-shifters:** These tiny dots can act as different shapes. Sometimes, they act like tiny dots, but other times, they act like waves on the water. It's like they can change their shape just by magic!\n\n2. **Secret Buddies:** Imagine these tiny dots have secret friends. Even if you take one of these dots far away, when you do something to the dot with you, the secret buddy dot reacts instantly, no matter how far apart they are!\n\n3. **Mystery Watchers:** In the quantum world, just watching these tiny dots can change what they do. It's like if you watch a magic trick, and every time you look, the trick changes in a different way!\n\nQuantum physics is the study of these magical, tiny dots and their surprising behavior. Scientists learn so much from them, and they use this knowledge to make new inventions and technologies. It's like a magical mystery adventure!"
    ]
}
`<br><br>
Using Gemini and temperature 0.2<br>
Request:
```json
{
    "input": "Explain quantum physics to a child.",
    "temperature": 0.2,
    "modelName": "gemini-1.5-pro-preview-0409",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        "Imagine the tiniest building blocks ever, way smaller than even your toys! These blocks, called \"quantum particles,\" make up everything around us.\n\nNow, these particles are super playful and have surprising rules:\n\n1. **Zoom, they're waves!** Sometimes, these tiny particles act like tiny balls, but other times, they act like waves in the ocean, spreading out like magic!\n\n2. **Best friends forever!** Imagine two particles holding hands. Even if we separate them, whatever happens to one instantly affects the other, as if they have an invisible string connecting them. It's like magic, but it's called \"entanglement\"!\n\n3. **Peek-a-boo, I changed!** Just by looking at these tiny particles, we can change how they act. It's like they are shy and change their behavior when we try to observe them! \n\nQuantum physics studies this magical world of tiny particles. It's like discovering the secret language of the universe! \n"
    ]
}
`<br>

##### Making similar requests, but with another temperature

Using GPT-4o and temperature 0.7<br>
Request:
```json
{
    "input": "Explain quantum physics to a child.",
    "temperature": 0.7,
    "modelName": "gpt-4o",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        "Sure! Let's think about the world as if it were made of tiny magical LEGO pieces that are so small, we can't see them. These pieces are called particles, and they build everything around us—plants, animals, even you!\n\nNow, these particles have some magical qualities:\n\n1. **Shape-Shifter Particles:** Imagine you have a tiny LEGO piece that can be a square and a triangle at the same time until you look at it closely. This is because particles can act like they’re in more than one place or shape at once!\n\n2. **Invisible Friends:** Pretend you have a magical twin LEGO piece. Even if one is on the other side of the world, they still copy each other instantly, like magic. This special friendship is called \"entanglement.\"\n\n3. **Peek-a-Boo Changes:** Imagine if by simply looking in your toy box, the toys decided to change places or shapes. In the particle world, whenever we look at them, it can change what they are doing.\n\nSo, quantum physics is like a magical set of rules for how these tiny LEGO pieces, or particles, behave. Scientists study these rules to uncover amazing secrets about our world and to invent new things! Isn’t that magical and fun?"
    ]
}
`<br><br>
Using Mixtral and temperature 0.7<br>
Request:
```json
{
    "input": "Explain quantum physics to a child.",
    "temperature": 0.7,
    "modelName": "Mixtral-8x7B-Instruct-v0.1",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        " Alright! Imagine the world is made up of tiny magical treasures, so small that you can't even see them with your eyes. These magical treasures are called \"particles.\"\n\nNow, these particles have some amazing secrets:\n\n1. **Sneaky Particles:** Imagine you have a sneaky treasure that's hiding in two places at the same time. That's what particles can do! They can be in more than one place at once.\n\n2. **Twins Tale:** Imagine two magical treasures that are always together, no matter where they are in the world. They change at the same time, even if they're very, very far apart. Scientists call this \"quantum entanglement.\"\n\n3. **Peek-a-Boo Trick:** Imagine if your toys changed just because you looked at them. In the quantum world, that's exactly what happens! We call this the \"observer effect.\"\n\nQuantum physics is the study of these magical, tiny particles and their secrets. Scientists work hard to understand this magical world and discover new things, like powerful computers and faster ways to send messages!"
    ]
}
`<br><br>
Using Gemini and temperature 0.7<br>
Request:
```json
{
    "input": "Explain quantum physics to a child.",
    "temperature": 0.7,
    "modelName": "gemini-1.5-pro-preview-0409",
    "functionsEnabled": false
}
```
Response:
`
{
    "messages": [
        "You know how everything is made of tiny things called atoms, right? Well, quantum physics is like a secret code that tells those tiny atoms how to act! \n\nImagine the atoms are like tiny dancers. In normal physics, they dance in a regular way, like waltzing. But in quantum physics, they can do all sorts of crazy moves:\n\n* **Superposition:** It's like a dancer being in multiple places on the dance floor *at the same time*! It's like magic, but it's how atoms can be in multiple states at once. \n\n* **Entanglement:** Imagine two of these dancers far apart, but when one spins, the other spins too, instantly! It's like they have an invisible string connecting them. That's entanglement – spooky action at a distance! \n\n* **The Observer Effect:** This is like when you watch the dancers, they get shy and change their dance moves! Just by observing the tiny atoms, we can actually change what they're doing.\n\nQuantum physics is a bit mind-boggling, but it's what makes the world work in all sorts of amazing ways! \n"
    ]
}
`<br>

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
