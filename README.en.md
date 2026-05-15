
# core-mc-plugin

![Java 8](https://img.shields.io/badge/Java-8-orange?logo=java) ![MIT License](https://img.shields.io/badge/License-MIT-green)

CoreMc is a multifunctional plugin for Minecraft servers running on Paper 1.12.2, providing a comprehensive server management system with advanced gameplay customization features.

## 🌟 Features
### 🎯 Player Management
* **Vanish system** – temporarily hide players from others
* **Teleportation** – warp system with customizable warp points
* **Flight mode** – control the ability to fly
* **Moderation tools** – kick and kill commands
### 🛡️ Protection & Restrictions
* **Anti-WDL** – protection against world downloading
* **World restrictions** – disable physics, portals, advancements
* **Mob control** – disable mob AI
* **PvP lock** – prevent players from fighting each other
### ⚡ Gameplay Enhancements
* **Perk system** – extra health, hunger, speed
* **Fall protection** – disable fall damage
* **Void rescue** – teleport players when falling into the void
* **Welcome sequence** – special effects upon joining
### 🎮 Additional Features
* **Starter items** – customizable items given on first join
* **Custom server brand** – change the displayed server name
* **Console filter** – hide unwanted console messages
* **Hide system messages** – join/quit/death message suppression

Note: see the details in the YML configs.

## 📥 Installation
1. Make sure your server is running **Paper 1.12.2** or a compatible fork
2. Download the latest plugin version
3. Place the JAR file into the `plugins/` folder
4. Restart the server
5. Configure the plugin via configuration files

## 📚 Commands
| Command                         | Description         |
|---------------------------------|---------------------|
| `/vanish [player]`              | Toggle invisibility |
| `/warp <name> [player]`         | Teleport to a warp  |
| `/fly`                          | Toggle flight       |
| `/kick <player\|@all> <reason>` | Kick a player       |
| `/kill <player\|@all>`          | Kill a player       |

## ⚙️ Requirements
* **Minecraft**: 1.12.2
* **Server**: Paper or forks
* **Java**: 8+

## 📜 License
Distributed under the **[MIT](LICENSE.txt)** license.

This project uses open-source components. Details about licensing can be found in **[pom.xml](pom.xml)** and on the official websites of the dependencies.
